function ListNode(data, count = 1) {
    this.count = count;
    this.data = data;
    this.prev = null;
    this.succ = null;
}

ListNode.prototype.insertAfter = function insertAfter(node) {
    this.succ.prev = node;
    node.succ = this.succ;
    this.succ = node;
    node.prev = this;
};

ListNode.prototype.remove = function remove() {
    this.prev.succ = this.succ;
    this.succ.prev = this.prev;
};

/**
 * Initialize your data structure here.
 */
function AllOne() {
    const header = new ListNode(new Set(), 0);
    const tailer = new ListNode(new Set(), Infinity);
    header.succ = tailer;
    tailer.prev = header;

    const map = new Map(); // count => node
    map.set(0, header);
    map.set(Infinity, tailer);
    const cmap = new Map(); // key => count
    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     * @param {string} key
     * @return {void}
     */
    const inc = key => {
        let count = cmap.get(key) || 0;
        count += 1;
        cmap.set(key, count); // 修正计数
        const last = map.get(count - 1); // 找到之前的节点
        let node = map.get(count); // 得到新阶层
        if (!node) {
            // 新阶层可能不存在
            node = new ListNode(new Set(), count);
            last.insertAfter(node); // 插入到之前阶层的下一阶层
            map.set(count, node); // 将该阶层加入到 map
        }
        node.data.add(key); // 加入新阶层（阶层跃升完毕）

        if (1 < count) {
            // 从原有阶层剔除掉
            last.data.delete(key); // 从之前节点删除，阶层跃升了。

            if (last.data.size === 0) {
                // 原阶层是否需要删除
                map.delete(count - 1); // 删除映射表
                last.remove(); // 从列表删除
            }
        }
    };

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     * @param {string} key
     * @return {void}
     */
    const dec = key => {
        let count = cmap.get(key); // 根据映射表找到该key的计数值
        if (!count) return; // 不存在则直接退出
        const last = map.get(count); // 找到原有阶层
        count -= 1;

        if (count) {
            cmap.set(key, count); // 更新计数映射表
            let node = map.get(count); // 尝试获取新阶层
            if (!node) {
                // 新阶层可能不存在，需要创建
                node = new ListNode(new Set(), count);
                last.prev.insertAfter(node); // 新阶层插入到之前阶层前序阶层的后面
                map.set(count, node); // 将该阶层加入的映射表
            }
            node.data.add(key); // 加入新阶层（阶层滑落完毕）
        } else {
            // 可能要直接消失
            cmap.delete(key); // 从计数映射表移除
        }
        last.data.delete(key); // 从原有阶层移除
        if (last.data.size === 0) {
            // 原阶层是否需要删除
            map.delete(count + 1); // 删除映射表
            last.remove(); // 从列表删除
        }
    };
    /**
     * Returns one of the keys with maximal value.
     * @return {string}
     */
    const getMaxKey = () => Array.from(tailer.prev.data)[0] || "";

    /**
     * Returns one of the keys with Minimal value.
     * @return {string}
     */
    const getMinKey = () => Array.from(header.succ.data)[0] || "";

    return { inc, dec, getMaxKey, getMinKey };
}