package life.majiang.community.mapper;

import life.majiang.community.model.Publish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PublishMapper {

    @Insert("INSERT INTO PUBLISH (CREATOR, TITLE, DESCRIPTION, TAG, LIKE_COUNT, VIEW_COUNT, COMMENT_COUNT) VALUES (#{creator},#{title},#{description},#{tag},#{likeCount},#{viewCount},#{commentCount})")
    void insert(Publish publish);
}
