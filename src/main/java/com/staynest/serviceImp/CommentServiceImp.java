package com.staynest.serviceImp;
import com.staynest.DTO.CommentDTO;
import com.staynest.entity.Comments;
import com.staynest.mapper.CommentMapper;
import com.staynest.repository.CommentRepository;
import com.staynest.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImp implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comments comment = CommentMapper.toEntity(commentDTO);
        comment.setDateTime(LocalDateTime.now()); // Set timestamp
        Comments savedComment = commentRepository.save(comment);
        return CommentMapper.toDTO(savedComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPropertyId(Long propertyId) {
        return commentRepository.findByPropertyId(propertyId)
                .stream()
                .map(CommentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
