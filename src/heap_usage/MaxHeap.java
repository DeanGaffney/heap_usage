package heap_usage;
import controllers.FileData;

public class MaxHeap {

	public MaxHeap() throws Exception{
		FileData fileData = new FileData();
		fileData.readFile();
	}
}
