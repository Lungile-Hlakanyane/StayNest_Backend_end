package com.staynest.controller;
import com.staynest.DTO.CommentDTO;
import com.staynest.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private final CommentService commentService;
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
        return commentService.addComment(commentDTO);
    }
    @GetMapping("/property/{propertyId}")
    public List<CommentDTO> getCommentsByProperty(@PathVariable Long propertyId) {
        return commentService.getCommentsByPropertyId(propertyId);
    }
}
