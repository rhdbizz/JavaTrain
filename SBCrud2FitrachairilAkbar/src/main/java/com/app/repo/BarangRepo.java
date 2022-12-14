package com.app.repo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.models.BarangModel;

public interface BarangRepo extends JpaRepository<BarangModel, Integer> {
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime Date = LocalDateTime.now();
	
	// List Barang
	@Query(value = "select * from m_barang order by id_barang Asc", nativeQuery = true)
	List<BarangModel> RBarang();

	// Total jumlah barang
	@Query(value = "select sum(m_qty) from m_barang", nativeQuery = true)
	int totalbarang();

	// Insert Barang Baru
	@Modifying
	@Query(value = "insert into m_barang(m_nama,m_supplier,m_qty,m_created)" + "values(?1,?2,?3,?4)", nativeQuery = true)
	void addBarang(String nm, String sup, int qty, String createdon);
	
	// Delete Barang
	@Modifying
	@Query(value = "delete from m_barang where id_barang=:id", nativeQuery = true)
	void delBarang(int id);

	@Modifying
	@Query(value = "update m_barang set m_nama=:nm,m_supplier=:sup,m_qty=:qty where id_barang=:id", nativeQuery = true)
	void edtBarang(int id, String nm, String sup, int qty);
	
	// List Edit Barang
	@Query(value="select * from m_barang where id_barang=:id", nativeQuery = true)
	List<BarangModel> RBarang2(int id);
	
	//Update Barang
	@Modifying
	@Query(value="update m_barang set nama_barang=:nm, supplier=:sup, qty=:qty, modified_on=:modifiedon where id_barang=:id", nativeQuery = true)
	void edtBarang(int id, String nm,  String sup, int qty, String modifiedon);
}


	
