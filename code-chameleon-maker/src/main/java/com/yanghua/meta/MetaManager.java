package com.yanghua.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName MetaManager.java
 * @Description TODO 读取 mate json 文件 的类：使用 双解锁 单例模式
 * 也可以使用 饿汉式单例模式
 * @createTime 2024年07月28日 14:14:00
 */
public class MetaManager {

    /**
     * 使用单例模式，减少代码重复创建，消耗资源，只初始化一次
     * <p>
     * 使用 双解锁 单例模式
     */

    // 使用volatile 为了确保 多线程环境下的内存可见性，使得多个线程可以实时看见该数据的最新值，防止信息不同步（本地存储导致的延迟-过段时间才同步）
            // 保证 meta 对象一旦被修改，其他现场就能够看到
    private static volatile Meta meta;

    public static Meta getMetaObject() {
        // 第一层判断：synchronized锁在一定程度上也是消耗资源的，故利用第一层判空进行初步过滤
        if (meta == null) {
            // 加锁，防止重复创建
            synchronized (MetaManager.class) {
                // 第二层判空：多线程情况下，第一个线程创建对象后，防止其他对象重复创建，再次判空
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMata = JSONUtil.toBean(metaJson, Meta.class);
        // todo 校验配置文件，处理默认值
        return newMata;
    }

}
