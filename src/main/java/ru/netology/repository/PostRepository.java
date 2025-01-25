package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PostRepository {
    private final Map<Long, Post> repo = new HashMap<>();

    public List<Post> all() {
        return new ArrayList<>(repo.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(repo.get(id));
    }

    public Post save(Post post) {
        repo.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        repo.remove(id);
    }
}
