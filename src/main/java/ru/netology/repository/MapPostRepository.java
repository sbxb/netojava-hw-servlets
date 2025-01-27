package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MapPostRepository implements PostRepository {
    private final Map<Long, Post> repo = new ConcurrentHashMap<>();
    private final AtomicLong autoincrement = new AtomicLong();

    public List<Post> all() {
        return new ArrayList<>(repo.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(repo.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(autoincrement.incrementAndGet());
        }
        repo.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        repo.remove(id);
    }
}
