package kmitl.sci.cs.entp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.model.PatchUserRequest;
import kmitl.sci.cs.entp.model.User;
import kmitl.sci.cs.entp.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}
	
	@Override
    public void update(User user, PatchUserRequest request) {
        updateUser(user, request);
        repository.save(user);
    }
	
	public void updateUser(User user, PatchUserRequest request) {
        if (request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
    }
	
	@Override
	public void delete(long userId) {
		// TODO Auto-generated method stub
		 repository.deleteByUserId(userId);
		
	}

	@Override
	public User getUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return repository.findByFirstName(firstName);
	}
	
}
