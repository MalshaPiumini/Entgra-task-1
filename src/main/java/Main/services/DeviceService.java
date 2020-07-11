package Main.services;

import Main.model.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface DeviceService {
    public List<Device> retrieve_AllDevices();
    public Device retrieve_Device(long deviceId);
    public Device add_Device(Device user);
    public Device update_Device(Device device,long deviceId);
    public ResponseEntity<Device> delete_Device(long deviceId);
}
