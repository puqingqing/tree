package onetree.service;


import onetree.bean.Kk;

import java.util.List;

public interface KkService {
    //查询所有
    public List<Kk> findAll();

    //根据id进行查询
    Kk findOne(Integer id);

    //根据id进行删除
    void deleteOne(Integer id);
}
