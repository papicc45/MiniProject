package com.miniproject.minibank.branch;

import org.hibernate.boot.jaxb.mapping.spi.JaxbPrePersist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
