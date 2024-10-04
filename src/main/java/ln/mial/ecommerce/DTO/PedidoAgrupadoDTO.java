package ln.mial.ecommerce.DTO;

import ln.mial.ecommerce.infraestructure.entity.DetallePedidosEntity;

import java.math.BigDecimal;
import java.util.List;

public class PedidoAgrupadoDTO {
    private String username;
    private List<DetallePedidosEntity> detallesPedido;
    private BigDecimal totalAmount;
    private String imagenPago;

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<DetallePedidosEntity> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedidosEntity> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getImagenPago() {
        return imagenPago;
    }

    public void setImagenPago(String imagenPago) {
        this.imagenPago = imagenPago;
    }
}

