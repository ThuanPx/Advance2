package com.example.ths.advance1_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ths on 08/05/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> mSongs;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SongAdapter(List<Song> mSongs, Context mContext) {
        this.mSongs = mSongs;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.row_item, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song song = mSongs.get(position);
        holder.tvCode.setText(song.getmCode());
        holder.tvTitle.setText(song.getmTitle());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvArtist.setText(song.getmArtist());
    }

    public void addSong(Song song) {
        mSongs.add(song);
        notifyItemInserted(mSongs.size() - 1);
    }

    public void removeSong(int position) {
        mSongs.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCode;
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvCode = (TextView) itemView.findViewById(R.id.tv_code);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeSong(getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }
}
