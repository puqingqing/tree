package onetree.controller;

import onetree.bean.Kk;
import onetree.service.KkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KkController {

    @Autowired
    private KkService kkService;

    @RequestMapping("/all")
    public List<Kk> findAll(){
        return kkService.findAll();
    }

    @RequestMapping("/one")
    public Kk findOne(Integer id){
       return kkService.findOne(id);
    }

    @RequestMapping("/delete")
    public boolean delete(Integer id){
        try{
            kkService.deleteOne(id);
            return  true;
        }catch (Exception e){
            return false;
        }

    }
}
