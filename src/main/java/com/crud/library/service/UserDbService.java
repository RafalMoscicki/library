package com.crud.library.service;

import com.crud.library.domain.User;
import com.crud.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDbService {

    @Autowired
    private final UserRepository userRepository;

    public User addUser(final User user) {
        return userRepository.save(user);
    }




//    public List<Exemplar> getAllAvailableExemplars(Book book) {
//        List<Exemplar> exemplars = new ArrayList<>();
//
//        List<Exemplar> availableExemplars = new ArrayList<>();
//        for (Exemplar exemplar : exemplars) {
//            if (exemplar.getStatus() == ExemplarStatus.AVAILABLE) {
//                availableExemplars.add(exemplar);
//            }
//        }
//        return availableExemplars;
//    }
}
