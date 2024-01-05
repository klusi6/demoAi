package org.example.demoai.repository;

import org.example.demoai.model.PromptAndResponse;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PromptAndResponseRepository extends JpaRepository<PromptAndResponse, Long> {
}
