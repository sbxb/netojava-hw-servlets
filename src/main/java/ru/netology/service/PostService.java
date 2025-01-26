package ru.netology.service;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) throws NotFoundException {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) throws NotFoundException {
        // explicitly refuse to update a nonexistent post
        if (post.getId() != 0 && repository.getById(post.getId()).isEmpty()) {
            throw new NotFoundException();
        }
        return repository.save(post);
    }

    public void removeById(long id) throws NotFoundException {
        // explicitly refuse to delete a nonexistent post
        if (repository.getById(id).isEmpty()) {
            throw new NotFoundException();
        }
        repository.removeById(id);
    }
}

