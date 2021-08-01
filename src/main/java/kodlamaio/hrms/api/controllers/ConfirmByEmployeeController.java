package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employersconfirm")
@CrossOrigin
public class ConfirmByEmployeeController {
    private ConfirmByEmployeeService confirm;

    @Autowired
    public ConfirmByEmployeeController(ConfirmByEmployeeService confirm) {
        this.confirm = confirm;
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestBody ConfirmByEmployee confirmByEmployee){
       return this.confirm.confirm(confirmByEmployee);
    }
}
