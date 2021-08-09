package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
@CrossOrigin
public class FavoriteController {
    private FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
   public Result add(@RequestBody Favorite favorite){
        return favoriteService.add(favorite);
    }

    @GetMapping("/getall")
    public DataResult<List<Favorite>> getAll(){
        return favoriteService.getAll();
    }

    @GetMapping("/GetDetailByUserId")
    public DataResult<FavoriteDto> getDetailByUserId(@RequestParam int userId){
        return favoriteService.getDetailByUserId(userId);
    }
}
