package com.staynest.service;
import com.staynest.DTO.CommentDTO;
import java.util.List;

public interface CommentService {
    CommentDTO addComment(CommentDTO commentDTO);
    List<CommentDTO> getCommentsByPropertyId(Long propertyId);
}
