package Main.controller;

import Main.model.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public interface DeviceC {

//    @GetMapping( "/item" )
//    public String getStockItem();

    @GetMapping
    public List<Device> getAllDevices();

    @GetMapping("/{id}")
    public Device getDevicesById(@PathVariable(value = "id")long deviceId);

    @PostMapping
    public Device createDevice(@RequestBody Device user);

    @PutMapping("/{id}")
    public Device updateDevice(@RequestBody Device device,@PathVariable("id")long deviceId);

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable("id")long deviceId);
}
