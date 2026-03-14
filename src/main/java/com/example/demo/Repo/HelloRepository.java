package com.example.demo.Repo;
import com.example.demo.Entity.Jtable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Jtable, Long> {
}
