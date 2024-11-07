import java.util.ArrayList;
import java.util.List;

public class M10StackPracticeExampleAnswers {
	
	public static void main(String[] args) {
		
		Folder topFolder = new Folder("top-folder");
		Folder folder = topFolder;
		int numFiles = 10;
		for(int i=0; i<numFiles; i++) {
			Folder newFolder = new Folder("new-folder-" + i);
			newFolder.addFile(new FileItem("new-file-" + i, 1));;
			folder.addSubFolder(newFolder);
			folder = newFolder;
		}
		
		String fileName = "new-file-" + (numFiles-1);
		FileItem fileToFind = new FileItem(fileName, 1);
		System.out.println(topFolder + " contains this file: " + fileName + " (result should be true)");
		System.out.println(topFolder.containsFile(fileToFind));
//		System.out.println(containsFileRecursion(topFolder, fileToFind));
		System.out.println(containsFileStack(topFolder, fileToFind));


		fileName = "new-file-" + (numFiles);
		fileToFind = new FileItem(fileName, 1);
		System.out.println(topFolder + " does NOT contain this file: " + fileName + " (result should be false)");
		System.out.println(topFolder.containsFile(fileToFind));
//		System.out.println(containsFileRecursion(topFolder, fileToFind));
		System.out.println(containsFileStack(topFolder, fileToFind));

	}

	public static boolean containsFileStack(Folder folder, FileItem file) {
		List<Folder> stack = new ArrayList<>();
		Folder currentFolder;
		stack.add(folder);
		while (!stack.isEmpty()) {
			currentFolder = stack.getLast();
			if (currentFolder.containsFileDirectly(file)) {
					return true;
			}

            stack.removeLast();
			stack.addAll(currentFolder.getSubFolders());
		}

		return false;
	}

	/*
	public static boolean containsFileRecursion(Folder folder, FileItem file) {
		if(folder.containsFileDirectly(file)) {
			return true;
		} else {
			for(Folder subFolder : folder.getSubFolders()) {
				if(subFolder.containsFileDirectly(file)) {
					return true;
				} else {
					return containsFileRecursion(subFolder, file);
				}
			}
			return false;
		}
	}
*/

	

	
	
}
