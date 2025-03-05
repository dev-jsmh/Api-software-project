/*

Jhonatan Samuel Martinez Hernandez
Software Analyst and Developer
Year 2024
 */
package jhonatan.decoramor.provider;


public class ProviderDto {
    
    private Long providerId;
    private String nit;
    private String name;
    private String phone;
    private String address;
     // ============ Empty constructor ============
    public ProviderDto(){}
    // ============ Constructor with arguments ============
    public ProviderDto( Long providerId, String nit, String name, String phone, String address ){
    
        this.providerId = providerId;
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.address = address;
        
    }
    
    // ============ getter and setters ============

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
