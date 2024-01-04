package org.example.demoai.repository;

import org.example.demoai.model.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PromptRepository extends JpaRepository<Prompt, Long> {
}
