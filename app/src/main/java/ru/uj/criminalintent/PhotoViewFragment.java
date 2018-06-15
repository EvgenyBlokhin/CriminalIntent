package ru.uj.criminalintent;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Blokhin Evgeny on 08.06.2018.
 */
public class PhotoViewFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView mPhotoViewer;

    public static PhotoViewFragment newInstance(File photo) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photo);

        PhotoViewFragment fragment = new PhotoViewFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO);
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        mPhotoViewer = v.findViewById(R.id.image_photo_viewer);
        mPhotoViewer.setImageURI(FileProvider.getUriForFile(getActivity(), "ru.uj.android.criminalintent.fileprovider", photoFile));
        return new AlertDialog.Builder(getActivity()).setView(v).setPositiveButton(android.R.string.ok, null).create();
    }
}
