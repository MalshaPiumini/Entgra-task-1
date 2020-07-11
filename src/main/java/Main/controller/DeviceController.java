package Main.controller;

import Main.exception.ResourceNotFoundException;
import Main.model.Device;
import Main.repository.DeviceRepository;
import Main.services.Device_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController implements DeviceC{

    @Autowired
    private Device_Service device_service;

    @Override
    public String getStockItem() {
        return "It's working...!";
    }

    //get All Devices
    @Override
    public List<Device> getAllDevices(){
        return this.device_service.retrieve_AllDevices();
    }

    //get Device By Id
    @Override
    public Device getDevicesById(@PathVariable(value = "id")long deviceId){
        return this.device_service.retrieve_Device(deviceId);
    }

    //create Device
    @Override
    public Device createDevice(@RequestBody Device device){
        return this.device_service.add_Device(device);
    }

    //update Device
    @Override
    public Device updateDevice(@RequestBody Device device,@PathVariable("id")long deviceId){
       return this.device_service.update_Device(device,deviceId);
    }

    //delete device by id
    @Override
    public ResponseEntity<Device> deleteDevice(@PathVariable("id")long deviceId) {
        return this.device_service.delete_Device(deviceId);
    }
}
