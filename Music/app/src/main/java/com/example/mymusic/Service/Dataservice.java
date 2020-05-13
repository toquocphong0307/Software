package com.example.mymusic.Service;




import com.example.mymusic.Model.Album;
import com.example.mymusic.Model.Baihat;
import com.example.mymusic.Model.ChuDe;
import com.example.mymusic.Model.Playlist;
import com.example.mymusic.Model.Quangcao;

import com.example.mymusic.Model.TheLoai;
import com.example.mymusic.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//  gửi phương thức và nhận dữ liệu từ phía server
public interface Dataservice {

    //gửi tương tác lên server
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbum();

    @GET("LoveSong.php")
    Call<List<Baihat>> GetBaihat();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheochude(@Field("idtheloai") String idtheloai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllchude();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);

    @GET("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> Updateluotthich(@Field("luotthich") String luotthich, @Field("idbaihat")String idbaihat);

    @FormUrlEncoded
    @POST("timkiembaihat.php")
    Call<List<Baihat>> GetSearchbaihat(@Field("tukhoa") String tukhoa);


}
