package com.gmail.samoha199412.dao.folder;

import com.gmail.samoha199412.entities.folder.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderDao extends JpaRepository<Folder, Long> {
}
