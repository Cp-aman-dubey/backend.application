package aman.dubey.backend.app.controller;

import aman.dubey.backend.app.exception.ExceptionHandling;
import aman.dubey.backend.app.model.Associates;
import aman.dubey.backend.app.repository.AssociatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AssociatesController {


    @Autowired
    private AssociatesRepository associatesRepository;


    @GetMapping("/associates")
    public List<Associates> getAllAssociates(){
        return associatesRepository.findAll();
    }


    @PostMapping("/associates")
    public Associates createAssociates(@RequestBody Associates associates) {
        return associatesRepository.save(associates);
    }


    @GetMapping("/associates/{id}")
    public ResponseEntity<Associates> getAssociateById(@PathVariable Long id) {
       Associates associates = associatesRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandling("Employee not exist with id :" + id));
        return ResponseEntity.ok(associates);
    }



    @PutMapping("/associates/{id}")
    public ResponseEntity<Associates> updateAssociates(@PathVariable Long id, @RequestBody Associates associatesDetail){
       Associates associates = associatesRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandling("Employee not exist with id :" + id));

        associates.setFirstName(associatesDetail.getFirstName());
        associates.setLastName(associatesDetail.getLastName());
        associates.setEmailId(associatesDetail.getEmailId());

       Associates updatedAssociates = associatesRepository.save(associates);
        return ResponseEntity.ok(updatedAssociates);
    }


    @DeleteMapping("/associates/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAssociate(@PathVariable Long id){
       Associates associates = associatesRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandling("Employee not exist with id :" + id));

        associatesRepository.delete(associates);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
