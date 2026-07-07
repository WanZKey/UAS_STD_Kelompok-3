# PoC - Linear Search

Repository ini merupakan implementasi **algoritma Linear Search** pada Program Manajemen Antrean Kantin Kampus yang dibuat menggunakan bahasa **Kotlin**.

Fitur pencarian memungkinkan pengguna mencari pelanggan berdasarkan nama tanpa harus mengetik nama secara lengkap (**Partial Match**). Proses pencarian dilakukan menggunakan algoritma **Linear Search**, yaitu memeriksa setiap elemen antrean dari depan hingga belakang sampai seluruh data selesai diperiksa.

Untuk informasi detail **Source Code** bisa klik [link] (https://github.com/WanZKey/UAS_STD_Kelompok-3/blob/main/Src/Searching/Penjelasan_Source-Code.md) ini.

---

# Source Code Linear Search

```kotlin
print(" Masukkan Nama Pelanggan : ")
val cari = readLine()?.trim() ?: ""

var ditemukan = 0

println()

println("+--------+------------------------------+")
println("| No     | Nama Pelanggan               |")
println("+--------+------------------------------+")

for ((index, nama) in antreanRestoran.withIndex()) {

    if (nama.contains(cari, ignoreCase = true)) {
        System.out.printf("| %-6d | %-28s |\n", index + 1, nama)
        ditemukan++
    }
}

if (ditemukan > 0) {
    println("+--------+------------------------------+")
    println()
    println(" Jumlah ditemukan : $ditemukan pelanggan")
} else {
    println(" Status : Pelanggan tidak ditemukan.")
}
```

---

# Penjelasan Source Code

Program terlebih dahulu meminta pengguna memasukkan nama pelanggan yang ingin dicari.

```kotlin
print(" Masukkan Nama Pelanggan : ")
val cari = readLine()?.trim() ?: ""
```

Selanjutnya program melakukan perulangan terhadap seluruh data antrean menggunakan `withIndex()`.

```kotlin
for ((index, nama) in antreanRestoran.withIndex())
```

Pada setiap perulangan, nama pelanggan dibandingkan menggunakan fungsi `contains()`.

```kotlin
nama.contains(cari, ignoreCase = true)
```

Penggunaan `contains()` memungkinkan pengguna melakukan pencarian sebagian nama (**Partial Match**), sehingga pencarian menjadi lebih fleksibel.

Jika ditemukan data yang sesuai, program akan menampilkan posisi antrean beserta nama pelanggan.

---

# Proses Menjalankan Program

## 1. Menambahkan Data Pelanggan

Sebelum melakukan pencarian, beberapa pelanggan dimasukkan terlebih dahulu ke dalam antrean.

```text
 󰋑  ▶  java -jar searching.jar
===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Radisa

 Sukses: 'Radisa' berhasil masuk antrean.

===================================================
 Tekan ENTER untuk kembali ke menu...

===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Riduan

 Sukses: 'Riduan' berhasil masuk antrean.

===================================================
 Tekan ENTER untuk kembali ke menu...

===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Viona

 Sukses: 'Viona' berhasil masuk antrean.

===================================================
 Tekan ENTER untuk kembali ke menu...
```

---

## 2. Menampilkan Daftar Antrean

Setelah seluruh pelanggan berhasil ditambahkan, program menampilkan isi antrean.

```text
===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 3

===================================================
             DAFTAR ANTREAN SAAT INI
===================================================

+--------+------------------------------+
| No     | Nama Pelanggan               |
+--------+------------------------------+
| 1      | Radisa                       |
| 2      | Riduan                       |
| 3      | Viona                        |
+--------+------------------------------+

 Jumlah antrean : 3 pelanggan

===================================================
 Tekan ENTER untuk kembali ke menu...
```

---

## 3. Melakukan Pencarian Menggunakan Kata Kunci "R"

Pengguna mencari pelanggan menggunakan huruf **R**.

```text
===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 4

===================================================
               CARI PELANGGAN
===================================================

 Masukkan Nama Pelanggan : R

+--------+------------------------------+
| No     | Nama Pelanggan               |
+--------+------------------------------+
| 1      | Radisa                       |
| 2      | Riduan                       |
+--------+------------------------------+

 Jumlah ditemukan : 2 pelanggan

===================================================
 Tekan ENTER untuk kembali ke menu...
```

Hasil pencarian menampilkan dua pelanggan karena keduanya mengandung huruf **R**, yaitu **Radisa** dan **Riduan**.

---

## 4. Melakukan Pencarian Menggunakan Kata Kunci "Rid"

Pengguna kemudian melakukan pencarian menggunakan kata **Rid**.

```text
===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 4

===================================================
               CARI PELANGGAN
===================================================

 Masukkan Nama Pelanggan : Rid

+--------+------------------------------+
| No     | Nama Pelanggan               |
+--------+------------------------------+
| 2      | Riduan                       |
+--------+------------------------------+

 Jumlah ditemukan : 1 pelanggan

===================================================
 Tekan ENTER untuk kembali ke menu...
```

Karena hanya **Riduan** yang memiliki kata **Rid**, maka hanya satu data yang ditampilkan.

---

## 5. Melakukan Pencarian Data yang Tidak Ada

Program juga dapat menangani pencarian yang tidak menghasilkan data.

```text
===================================================
     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Cari Pelanggan
 [5] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-5): 4

===================================================
               CARI PELANGGAN
===================================================

 Masukkan Nama Pelanggan : Joni

+--------+------------------------------+
| No     | Nama Pelanggan               |
+--------+------------------------------+
 Status : Pelanggan tidak ditemukan.

===================================================
 Tekan ENTER untuk kembali ke menu...
```

Program akan tetap memeriksa seluruh data antrean sebelum menyimpulkan bahwa pelanggan tidak ditemukan.

---

# Kesimpulan

Implementasi Linear Search pada program ini berhasil melakukan pencarian pelanggan dengan memeriksa setiap elemen antrean secara berurutan dari depan hingga belakang.

Dengan memanfaatkan fungsi `contains()`, pengguna tidak perlu memasukkan nama pelanggan secara lengkap sehingga proses pencarian menjadi lebih mudah dan lebih fleksibel dibandingkan pencarian yang menggunakan kecocokan penuh (_Exact Match_).
