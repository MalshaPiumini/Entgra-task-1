package Main.services;

import Main.exception.ResourceNotFoundException;
import Main.model.Device;
import Main.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Device_Service implements DeviceService{

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> retrieve_AllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device retrieve_Device(long deviceId) {
        return this.deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ deviceId));
    }

    @Override
    public Device add_Device(Device device) {
        return this.deviceRepository.save(device);
    }

    @Override
    public Device update_Device(Device device, long deviceId) {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ deviceId));
        existingDevice.setDeviceName(device.getDeviceName());
        existingDevice.setDeviceModel(device.getDeviceModel());
        existingDevice.setDeviceStatus(device.getDeviceStatus());
        existingDevice.setEnrolledTime(device.getEnrolledTime());
        return this.deviceRepository.save(existingDevice);
    }

    @Override
    public ResponseEntity<Device> delete_Device(long deviceId) {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ deviceId));
        this.deviceRepository.delete(existingDevice);
        return ResponseEntity.ok().build();
    }
}
