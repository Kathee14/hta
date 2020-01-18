package com.uis.simon.hta.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uis.simon.hta.entity.Usuario;
import com.uis.simon.hta.model.MUsuario;

@Component("mapper")
public class Mapper {
	
	public static List<MUsuario> convertirLista(List<Usuario> usuarios){
		List<MUsuario> mUsuario= new ArrayList<>();
		for( Usuario usuario: usuarios) {
			mUsuario.add(new MUsuario(usuario));
		}
		 return mUsuario;
	}

}
