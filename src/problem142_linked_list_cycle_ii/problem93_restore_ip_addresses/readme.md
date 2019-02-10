给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。





![111](https://img-blog.csdn.net/20180524101941403?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI2NDEwMTAx/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
如图：
- 快慢指针在c点相遇,快指针走过的路径有两种解释。
- 2x+2y=x+y+c+y
- 所以x=c，
- 所以c点和head同时前进，下次相遇即为环的起始点。