# LazyFragment
解决问题: 
-----------------------------------
    在多个Fragment需要加载的时候,启动速度往往会变慢.分析会发现并非所有的Fragment都需要第一时间将数据填充完毕.
    因为它们都还没有被用户所"看见".
    所以可以采取LazyLoad的方式,Fragment被显示后才加载数据.

    例如
    Toolbar + ViewPager + Fragment
![github](https://github.com/xmagicj/LazyFragment/blob/master/demo.gif "demo")  

使用说明: 
-----------------------------------
* extends BaseFragment<br />
    其他生命周期的方法需要重写 就自己overwrite<br />

### 两个方法重点说明:
* protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);<br />
    与 onCreateView 类似.<br />
    initViews 是只要 Fragment 被创建就会执行的方法.<br />
    也就是说如果我们不想用 LazyLoad 模式<br />
    则把所有的初始化 和 加载数据方法都写在 initViews 即可.

* protected abstract void initData();<br />
    若将代码写在initData中,则是会在Fragment真正显示出来后才会去加载.

注意事项:
-----------------------------------
    sample很简单.代码注释也写的很清楚
    有个FragmentTransaction的坑,在BaseFragment文件注释中有说明(注2部分)
    这里还是贴出来吧
    /**
     * <pre>
     * 若把初始化内容放到initData实现
     * 就是采用Lazy方式加载的Fragment
     * 若不需要Lazy加载则initData方法内留空,初始化内容放到initViews即可
     *
     * 注1:
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint。
     *
     * 注2:
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 针对初始就show的Fragment 为了触发onHiddenChanged事件 达到lazy效果 需要先hide再show
     * eg:
     * transaction.hide(aFragment);
     * transaction.show(aFragment);
     *
     * Created by Mumu
     * on 2015/11/2.
     * </pre>
     */

依赖
-----------------------------------
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.android.support:design:23.1.1'
