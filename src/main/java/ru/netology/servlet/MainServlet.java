package ru.netology.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.netology.controller.PostController;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;

import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private PostController controller;

    @Override
    public void init() {
        final var repository = new PostRepository();
        final var service = new PostService(repository);
        controller = new PostController(service);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final var path = request.getRequestURI();
        System.out.println("INFO Hit doGet() with " + path);

        if (path.equals("/api/posts")) {
            controller.all(response);
            return;
        }

        if (path.matches("/api/posts/\\d+")) {
            final var id = Long.parseLong(path.substring(path.lastIndexOf("/")));
            controller.getById(id, response);
            return;
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final var path = request.getRequestURI();
        if (path.equals("/api/posts")) {
            controller.save(request.getReader(), response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final var path = request.getRequestURI();
        System.out.println("INFO Hit doDelete() with " + path);
        if (path.matches("/api/posts/\\d+")) {
            final var id = Long.parseLong(path.substring(path.lastIndexOf("/") + 1));
            controller.removeById(id, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
