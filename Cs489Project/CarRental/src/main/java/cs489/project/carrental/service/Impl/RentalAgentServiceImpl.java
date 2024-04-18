package cs489.project.carrental.service.impl;

import cs489.project.carrental.model.domain.RentalAgent;
import cs489.project.carrental.repository.RentalAgentRepository;
import cs489.project.carrental.service.RentalAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalAgentServiceImpl implements RentalAgentService {

    @Autowired
    private RentalAgentRepository rentalAgentRepository;

    @Override
    public RentalAgent saveRentalAgent(RentalAgent rentalAgent) {
        return rentalAgentRepository.save(rentalAgent);
    }

    @Override
    public RentalAgent getRentalAgentById(Long id) {
        return rentalAgentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRentalAgent(Long id) {
        rentalAgentRepository.deleteById(id);
    }
}
