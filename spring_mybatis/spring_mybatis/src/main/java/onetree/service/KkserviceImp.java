package onetree.service;

import onetree.bean.Kk;
import onetree.dao.KkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KkserviceImp implements KkService {

    @Autowired
    private KkMapper kkMapper;

    @Override
    public List<Kk> findAll() {
        return kkMapper.findAll();
    }

    @Override
    public Kk findOne(Integer id) {
        return kkMapper.findOne(id);
    }

    @Override
    public void deleteOne(Integer id) {
      kkMapper.deleteOne(id);
    }
}
