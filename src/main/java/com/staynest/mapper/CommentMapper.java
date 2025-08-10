package com.staynest.mapper;
import com.staynest.DTO.CommentDTO;
import com.staynest.entity.Comments;
import org.springframework.stereotype.Component;
@Component
public class CommentMapper {
    public static CommentDTO toDTO(Comments comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getPropertyId(),
                comment.getComment(),
                comment.getDateTime(),
                comment.getUserId()
        );
    }
    public static Comments toEntity(CommentDTO dto){
        Comments comment = new Comments();
        comment.setId(dto.getId());
        comment.setPropertyId(dto.getPropertyId());
        comment.setComment(dto.getComment());
        comment.setDateTime(dto.getDateTime());
        comment.setUserId(dto.getUserId());
        return comment;
    }

}
