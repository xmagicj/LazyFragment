# LazyFragment
解决问题:
在多个Fragment需要加载的时候,启动速度往往会变慢.分析会发现并非所有的Fragment都需要第一时间将数据填充完毕.
因为它们都还没有被用户所"看见".
所以可以采取LazyLoad的方式,Fragment被显示后才加载数据.

例如
Toolbar + ViewPager + Fragment
