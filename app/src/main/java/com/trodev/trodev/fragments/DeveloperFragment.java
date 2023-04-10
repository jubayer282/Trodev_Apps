package com.trodev.trodev.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trodev.trodev.R;

public class DeveloperFragment extends Fragment {

    private LinearLayout facebook, github, linkedin, gmail;
    private ImageView jubu_facebook, jubu_github, jubu_linkedin, jubu_gmail ;
    private LinearLayout rubayet_facebook, rubayet_github, rubayet_linkedin, rubayet_gmail ;
    private ImageView pias_facebook, pias_github, pias_linkedin, pias_gmail ;

    public DeveloperFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_developer, container, false);

        facebook = view.findViewById(R.id.facebook);
        github = view.findViewById(R.id.github);
        linkedin = view.findViewById(R.id.linkedin);
        gmail = view.findViewById(R.id.gmail);

        //jubayer hossain
        jubu_facebook = view.findViewById(R.id.jubu_facebook);
        jubu_github = view.findViewById(R.id.jubu_github);
        jubu_linkedin = view.findViewById(R.id.jubu_linkedin);
        jubu_gmail = view.findViewById(R.id.jubu_gmail);

        //rubayet ifti
        rubayet_facebook = view.findViewById(R.id.rubayet_facebook);
        rubayet_github = view.findViewById(R.id.rubayet_github);
        rubayet_gmail = view.findViewById(R.id.rubayet_gmail);
        rubayet_linkedin = view.findViewById(R.id.rubayet_linkedin);

        //pias
        pias_facebook = view.findViewById(R.id.pias_facebook);
        pias_github = view.findViewById(R.id.pias_github);
        pias_gmail = view.findViewById(R.id.pias_gmail);
        pias_linkedin = view.findViewById(R.id.pias_linkedin);


        //facebook zobayer
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent());
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/zobayerdev"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/zobayerdev/"));
                startActivity(intent);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "zobayer.dev@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Failed to due " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        jubu_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntentjubu());
            }
        });

        jubu_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/jubayer282"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        jubu_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jubayer-hossain-760b7623b"));
                startActivity(intent);
            }
        });

        jubu_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "jubayer.trodev@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Failed to due " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        rubayet_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntentrubayet());
            }
        });

        rubayet_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/SMd-Rubayet-Islam-Ifti"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        rubayet_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rubayet-islam-ifti-63073319a/"));
                startActivity(intent);
            }
        });

        rubayet_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "rubayet.trodev@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Failed to due " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



        pias_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntentpiash());
            }
        });

        pias_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/spias8"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        pias_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/piasmiah/"));
                startActivity(intent);
            }
        });

       pias_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "pias.trodev@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Failed to due " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }



    /*here zobayer hasan activity*/
    private PackageManager getPackageManager() {

        return null;
    }
    public Intent getOpenFacebookIntent() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/https://www.facebook.com/zobayerdev"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/zobayerdev"));
        }
    }

    // jubayer hossain
    private Intent getOpenFacebookIntentjubu() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/https://www.facebook.com/mdjubayer.hossain.98434"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mdjubayer.hossain.98434"));
        }
    }

    // rubayet ifti
    private Intent getOpenFacebookIntentrubayet() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/https://www.facebook.com/rubayetislamifti/"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rubayetislamifti/"));
        }
    }

    private Intent getOpenFacebookIntentpiash() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/https://www.facebook.com/mued.hasan.08/"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mued.hasan.08/"));
        }
    }


}