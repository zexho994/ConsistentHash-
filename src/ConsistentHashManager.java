import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Zexho
 * @date 2022/3/2 7:05 PM
 */
public class ConsistentHashManager {

    private static final int DEFAULT_VIR_NODE_COUNT = 30;
    private final int virNodeCount;
    private final SortedMap<Long, Node> ring = new TreeMap();
    private final HashUtil hashUtil = new Md5HashUtil();


    public ConsistentHashManager() {
        this.virNodeCount = DEFAULT_VIR_NODE_COUNT;
    }

    public ConsistentHashManager(int virNodeCount) {
        this.virNodeCount = virNodeCount;
    }

    public void addNode(Node node) {
        ring.put(hashUtil.hash(node.getKey()), node);
        for (int i = 0; i < this.virNodeCount; i++) {
            this.ring.put(hashUtil.hash(node.getKey() + i), node);
        }
    }

    public void removeNote() {

    }

    public Node getNextNote(int hash) {

        return null;
    }

    public int nodeCount() {
        return this.ring.size();
    }

}
