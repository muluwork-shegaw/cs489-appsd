//import cs489.project.carrental.model.domain.User;
//import cs489.project.carrental.repository.UserRepo;
//import cs489.project.carrental.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService, UserDetailsService {
//
//
//    private final BCryptPasswordEncoder pwdEncoder;
//    private final UserRepo userRepository;
//    private final RoleRepo roleRepo;
//    private final ModelMapper modelMapper;
//    private final Util util;
//
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id).get();
//    }
//
//    public User createUser(CreateUser user) {
//
////        if(user.getRoles().isEmpty()){
////            user.addRole(roleRepo.getByName("Creator"));
////        }
//        user.setPassword(pwdEncoder.encode(user.getPassword()));
//        User newUser = modelMapper.map(user, User.class);
//        newUser.addRole(roleRepo.getByName("Creator"));
//        return userRepository.save(newUser);
//    }
//
//    @Override
//    public User updateUser(Long id, CreateUser user) {
//
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser != null) {
//            existingUser.setEmail(user.getEmail());
//            existingUser.setPassword(pwdEncoder.encode(user.getPassword()));
//            existingUser.setFirstname(user.getFirstname());
//            existingUser.setLastname(user.getLastname());
//            existingUser.setProfilePicture(user.getProfilePicture());
//            return userRepository.save(existingUser);
//        }
//
//        throw new NoSuchElementException("User Not Found.");
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        User user = getUserById(id);
//        userRepository.delete(user);
//    }
//
//    public Optional<User> findUserByEmail(String userName) {
//        return userRepository.findByEmail(userName);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> opt = findUserByEmail(email);
//        User user = opt.get();
//        if (opt.isEmpty()) {
//            throw new UsernameNotFoundException(" user doesn't exist");
//        }
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                user.getRoles().stream()
//                        .flatMap(role -> role.getPermissions().stream())
//                        .map(permission -> new SimpleGrantedAuthority(permission.getName()))
//                        .collect(Collectors.toSet()));
//
//        CustomUserDetails customUserDetails = new CustomUserDetails(userDetails);
//        customUserDetails.setId(user.getId());
//
//        return customUserDetails;
//    }
//
//    @Override
//    public CreatedResolvedReviewedAggregate currentUserAggregate() {
//        User user = util.getUserFromContext();
//        Long created = issueRepo.getCreationAggregate(user);
//        Long resolved = issueRepo.getResolveAggregate(user);
//        Long reviewed = issueRepo.getReviewAggregate(user);
//        Long closed = issueRepo.getClosedAggregate(user);
//
//        return new CreatedResolvedReviewedAggregate(created, resolved, reviewed, closed);
//    }
//
//    @Override
//    public BasicUserDto getCurrentUser() {
//        var User = util.getUserFromContext();
//        return modelMapper.map(User, BasicUserDto.class);
//    }
//
//
//    @Override
//    public List<User> getRecentUsers(Integer limit) {
//        return userRepository.getRecentUsers().stream().limit(limit).toList();
//    }
//
//    @Override
//    public User setRole(Long id, List<Long> roleIds) {
//
//        User user = getUserById(id);
//        var roles = roleRepo.findAllById(roleIds);
//        user.setRoles(null);
//        userRepository.save(user);
//        user.setRoles(roles);
//        return userRepository.save(user);
//
//    }
//
//    @Override
//    public BasicUserDto getUserByID(Long id) {
//        var user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return BasicUserDto.builder()
//                    .roles(user.get().getRoles())
//                    .firstname(user.get().getFirstname())
//                    .lastname(user.get().getLastname())
//                    .profilePicture(user.get().getProfilePicture())
//                    .email(user.get().getEmail())
//                    .id(user.get().getId())
//                    .build();
//        }
//
//        throw new NoSuchElementException("User not found");
//    }
//}