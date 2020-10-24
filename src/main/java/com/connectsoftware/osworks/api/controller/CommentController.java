package com.connectsoftware.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connectsoftware.osworks.api.model.CommentInput;
import com.connectsoftware.osworks.api.model.CommentModel;
import com.connectsoftware.osworks.domain.exception.BusinessException;
import com.connectsoftware.osworks.domain.model.Comment;
import com.connectsoftware.osworks.domain.model.OrdemService;
import com.connectsoftware.osworks.domain.repository.OrdemServiceRepository;
import com.connectsoftware.osworks.domain.service.OrdemServiceService;

@RestController
@RequestMapping("/ordem/{id}/comment")
public class CommentController {

	@Autowired
	private OrdemServiceService ordemServiceService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OrdemServiceRepository ordemServiceRepositoy;

	@GetMapping
	private List<CommentModel> list(@PathVariable Long id) {

		OrdemService ordemService = ordemServiceRepositoy.findById(id)
				.orElseThrow(() -> new BusinessException("Ordem de serviçao não encotrada"));
		return toCollectionModel(ordemService.getComment());

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentModel insert(@PathVariable Long id, @Valid @RequestBody CommentInput comment) {

		Comment comments = ordemServiceService.addComment(id, comment.getDescription());

		return toModel(comments);

	}

	private CommentModel toModel(Comment comment) {
		return modelMapper.map(comment, CommentModel.class);
	}

	private List<CommentModel> toCollectionModel(List<Comment> comment) {
		return comment.stream().map(comments -> toModel(comments)).collect(Collectors.toList());
	}

}
