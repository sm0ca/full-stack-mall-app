package com.example.cscb07project.ui.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cscb07project.MainActivity;
import com.example.cscb07project.R;
import com.example.cscb07project.databinding.FragmentShopBinding;
import com.example.cscb07project.ui.cart.CartFragment;

public class ShopFragment extends Fragment {

    private FragmentShopBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentShopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!MainActivity.isOwner) {
            NavHostFragment.findNavController(ShopFragment.this)
                    .navigate(R.id.action_navigation_shop_to_shop_storelist);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}