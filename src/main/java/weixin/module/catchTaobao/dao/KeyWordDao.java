package weixin.module.catchTaobao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import weixin.module.catchTaobao.entity.KeyWorldInfo;

import java.util.List;

public interface KeyWordDao extends JpaRepository<KeyWorldInfo, Integer> {

    @Query(value = "select * from key_world_info LIMIT ?1,?2", nativeQuery = true)
    List<KeyWorldInfo> findPageKeyWord(Integer begin, Integer end);
}
