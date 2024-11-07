import java.util.*;

public class Folder  {
	
	private List<Folder> subFolders;
	private List<FileItem> files;
	
	private String name;

	public Folder(String name) {
		this.name = name;
		this.subFolders = new ArrayList<Folder>();
		this.files = new ArrayList<FileItem>();
	}

	public List<Folder> getSubFolders() {
		return subFolders;
	}
	
	public List<FileItem> getFiles() {
		return files;
	}
	
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return name;
	}

	public void addFile(FileItem file) {
		files.add(file);
	}
	
	public void addSubFolder(Folder folder) {
		subFolders.add(folder);
	}
	
	public int getSizeOfFiles() {
		int fileSize = 0;
		for(FileItem file : files) {
			fileSize += file.getSize();
		}
		return fileSize;
	}
	
	public int getSize() {
		int totalSize = getSizeOfFiles();
		for(Folder folder : subFolders) {
			totalSize += folder.getSize();
		}
		return totalSize;
	}

	public boolean containsFileDirectly(FileItem file) {
		return files.contains(file);
	}
	
	public boolean containsFile(FileItem file) {
		if(containsFileDirectly(file)) {
			return true;
		} else {
			for(Folder folder : subFolders) {
				if(folder.containsFile(file)) {
					return true;
				}
			}
			return false;
		}
	}
	
}
