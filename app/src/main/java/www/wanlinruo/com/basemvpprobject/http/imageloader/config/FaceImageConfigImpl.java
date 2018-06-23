package www.wanlinruo.com.basemvpprobject.http.imageloader.config;


import www.wanlinruo.com.basemvpprobject.http.imageloader.glide.GlideCircleTransform;
import www.wanlinruo.com.basemvpprobject.http.imageloader.glide.ImageConfigImpl;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 简化头像配置
 *     version: 1.0
 * </pre>
 */
public class FaceImageConfigImpl {

    public static ImageConfigImpl.Builder builder() {
        return ImageConfigImpl.builder()
//                .placeholder(R.mipmap.ic_user_default)
//                .errorPic(R.mipmap.ic_user_default)
//                .fallback(R.mipmap.ic_user_default)
                .cacheStrategy(0)
                .transformation(new GlideCircleTransform());
    }

}
