package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MapPostRepository implements PostRepository {
    private final Map<Long, Post> repo = new ConcurrentHashMap<>();

    public List<Post> all() {
        return new ArrayList<>(repo.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(repo.get(id));
    }

    public Post save(Post post) {
        System.out.println("INFO: Repo saving post: " + post);
        repo.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        repo.remove(id);
    }
}
