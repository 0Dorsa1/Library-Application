package com.example.library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AllBooksRecyclerViewAdapter extends RecyclerView.Adapter<AllBooksRecyclerViewAdapter.ViewHolder> {

    static ArrayList<Book> allBooks = new ArrayList<>();
    Context context;
    String parentActivity;

    public AllBooksRecyclerViewAdapter(Context context, String parentActivity) {
        this.context = context;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_books_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookName.setText(allBooks.get(position).getName());
        Glide.with(context).asBitmap().load(allBooks.get(position).getImageURL()).into(holder.bookImage);

        holder.parentCardViewLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, BookClick.class);
            intent.putExtra("bookId", allBooks.get(position).getId());
            context.startActivity(intent);
        });

        holder.authorName.setText("Author Name: " + allBooks.get(position).getAuthor());
        holder.aboutAuthor.setText("About Author: " + allBooks.get(position).getAboutAuthor());
        holder.shortDescription.setText(allBooks.get(position).getShortDescription());

        if (allBooks.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parentCardViewLayout);
            holder.expandedRelative.setVisibility(View.VISIBLE);
            holder.downwardArrow.setVisibility(View.GONE);

            switch (parentActivity) {
                case "AllBooksActivity":
                    holder.deleteBtn.setVisibility(View.GONE);
                    break;
                case "AlreadyReadBooksActivity":
                    holder.deleteBtn.setVisibility(View.VISIBLE);
                    holder.deleteBtn.setOnClickListener(view -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + allBooks.get(position).getName() + " from ALREADY READ category?");
                        builder.setPositiveButton("YES", (dialogInterface, i) -> {
                            if (Utils.getInstance().removeFromAlreadyReadBooks(allBooks.get(position))) {
                                Toast.makeText(context, "Book Removed.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(context, "Something Went Wrong...Please Try Again Later.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("NO", (dialogInterface, i) -> {

                        });
                        builder.create().show();
                    });
                    break;
                case "CurrentlyReadingBooksActivity":
                    holder.deleteBtn.setVisibility(View.VISIBLE);
                    holder.deleteBtn.setOnClickListener(view -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + allBooks.get(position).getName() + " from CURRENTLY READING category?");
                        builder.setPositiveButton("YES", (dialogInterface, i) -> {
                            if (Utils.getInstance().removeFromCurrentlyReadingBooks(allBooks.get(position))) {
                                Toast.makeText(context, "Book Removed.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(context, "Something Went Wrong...Please Try Again Later.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("NO", (dialogInterface, i) -> {

                        });
                        builder.create().show();
                    });
                    break;
                case "MyFavoritesActivity":
                    holder.deleteBtn.setVisibility(View.VISIBLE);
                    holder.deleteBtn.setOnClickListener(view -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + allBooks.get(position).getName() + " from MY FAVORITES category?");
                        builder.setPositiveButton("YES", (dialogInterface, i) -> {
                            if (Utils.getInstance().removeFromFavorites(allBooks.get(position))) {
                                Toast.makeText(context, "Book Removed.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(context, "Something Went Wrong...Please Try Again Later.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("NO", (dialogInterface, i) -> {

                        });
                        builder.create().show();
                    });
                    break;
                case "WishListActivity":
                    holder.deleteBtn.setVisibility(View.VISIBLE);
                    holder.deleteBtn.setOnClickListener(view -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + allBooks.get(position).getName() + " from WISH LIST category?");
                        builder.setPositiveButton("YES", (dialogInterface, i) -> {
                            if (Utils.getInstance().removeFromWishList(allBooks.get(position))) {
                                Toast.makeText(context, "Book Removed.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(context, "Something Went Wrong...Please Try Again Later.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("NO", (dialogInterface, i) -> {

                        });
                        builder.create().show();
                    });
                    break;
                default:
                    break;
            }
        } else {
            TransitionManager.beginDelayedTransition(holder.parentCardViewLayout);
            holder.expandedRelative.setVisibility(View.GONE);
            holder.downwardArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return allBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView parentCardViewLayout;
        ImageView bookImage;
        TextView bookName;
        ImageView downwardArrow, upwardArrow;
        RelativeLayout expandedRelative;
        TextView authorName, aboutAuthor, shortDescription, deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentCardViewLayout = itemView.findViewById(R.id.parentCardViewLayout);
            bookImage = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.bookNameTxt);
            downwardArrow = itemView.findViewById(R.id.downwardArrowImg);
            upwardArrow = itemView.findViewById(R.id.upwardArrowImg);
            expandedRelative = itemView.findViewById(R.id.expandedRelative);
            authorName = itemView.findViewById(R.id.authorTxt);
            aboutAuthor = itemView.findViewById(R.id.aboutAuthorTxt);
            shortDescription = itemView.findViewById(R.id.shortDescriptionTxt);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

            downwardArrow.setOnClickListener(view -> {
                Book book = allBooks.get(getAdapterPosition());
                book.setExpanded(!book.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });

            upwardArrow.setOnClickListener(view -> {
                Book book = allBooks.get(getAdapterPosition());
                book.setExpanded(!book.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });

        }

    }

    public void setAllBooks(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
        notifyDataSetChanged();
    }


}

