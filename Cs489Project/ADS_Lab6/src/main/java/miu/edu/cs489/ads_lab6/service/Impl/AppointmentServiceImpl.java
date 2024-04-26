package miu.edu.cs489.ads_lab6.service.Impl;

import jakarta.transaction.Transactional;
import miu.edu.cs489.ads_lab6.domain.Appointment;
import miu.edu.cs489.ads_lab6.repository.AppointmentRepo;
import miu.edu.cs489.ads_lab6.service.AppointmentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class AppointmentImpl implements AppointmentService {

    private AppointmentRepo appointmentRepo;

    public AppointmentImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> getAppointments() {
//        return appointmentRepo.findAll(Sort.by(Sort.Direction.ASC,"appintmentDate"));
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointment(Long id) {
        return appointmentRepo.findById(id).get();
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentRepo
                .findById(appointment.getAppointmentId())
                .orElse(null);


        if(existingAppointment != null){
            existingAppointment.setStatus(appointment.getStatus());
        }
        return appointmentRepo.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(id);

    }
}
