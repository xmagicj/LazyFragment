# LazyFragment
### 解决问题: 
    在多个Fragment需要加载的时候,启动速度往往会变慢.分析会发现并非所有的Fragment都需要第一时间将数据填充完毕.
    因为它们都还没有被用户所"看见".
    所以可以采取LazyLoad的方式,Fragment被显示后才加载数据.

    例如
    Toolbar + ViewPager + Fragment


### 使用说明: 
    主要是继承BaseFragment,其他生命周期的方法需要重写 就自己overwrite
    BaseFragment有两个方法重点说明:
    protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    与onCreateView类似.initViews是只要Fragment被创建就会执行的方法.
    也就是说如果我们不想用LazyLoad模式,则把所有的初始化 和 加载数据方法都写在initViews即可.

    protected abstract void initData();
    若将代码写在initData中,则是会在Fragment真正显示出来后才会去加载.
